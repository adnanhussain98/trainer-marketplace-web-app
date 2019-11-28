package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Trainer;

/**
 * This class is the DA0 (Data Acessor Object). This class establishes a
 * connection to the database and it contains methods that will communicate with
 * the database
 **/
public class TrainerDAO {

	private Connection getConnection() {

		// creating connection object
		Connection conn = null;

		try {
			// load driver
			Class.forName("org.sqlite.JDBC");
			// url of the database location
			String url = "jdbc:sqlite:/Users/adnanhussain/Documents/TrainerMarketplaceWebApp/trainersDatabase.db";
			// initialise connection object
			conn = DriverManager.getConnection(url);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// returns conn object
		return conn;
	}

	// instead of returning void we want to return all trainers as objects - because
	// java will understand it and we can work with these objects
	// Returning an array list
	public ArrayList<Trainer> getTrainers() throws SQLException {

		// initialising array list
		ArrayList<Trainer> allTrainers = new ArrayList<>();

		// creating connection object inside the method
		Connection connection = getConnection();
		// statement object created which will hold the sql string that will be
		// executed.
		Statement statement = connection.createStatement();
		// adding the question marks to protect from SQL injection. question marks
		// represent parameters that are passed in to the sql
		// gets all trainers from the trainers table and stores it in sql string
		String sql = "SELECT * FROM trainers;";
		// prints the sql statement that has been executed
		System.out.println(sql);
		// result set catches the sql query result and then executes it.
		ResultSet rs = statement.executeQuery(sql);
		// while function iterates over each row until there's no more rows
		while (rs.next()) {
			// uses getters from Trainer class and stores them in rs object.
			int id = rs.getInt("ID");
			String brandName = rs.getString("brandName");
			String trainerName = rs.getString("trainerName");
			String colour = rs.getString("colour");
			float size = rs.getFloat("size");
			String condition = rs.getString("condition");
			String description = rs.getString("description");
			int price = rs.getInt("Price");
			// prints each row it has iterated over. Empty strings in sysout hold's the
			// trainers
			// information
			System.out.println(id + " " + brandName + " " + trainerName + " " + colour + " " + size + " " + condition
					+ " " + description + " " + price + " ");

			// create new trainer object
			Trainer trainer = new Trainer(id, brandName, trainerName, colour, size, condition, description, price);
			// adds the arguments from the dvd object to the allDvds array list
			allTrainers.add(trainer);

		}
		// Closing the connection as if you do not close it it will consume your
		// resource
		// continuously and will have overall impact on your application and it
		// may also not be added or returned to the pool.
		connection.close();
		// Returning the all the trainers from the arraylist that holds the trainer
		// objects
		return allTrainers;
	}

	public Trainer getSingleTrainer(int trainerId) throws SQLException {
		Connection connection = getConnection();

		Trainer trainer = null;

		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM trainers WHERE id = " + trainerId + "";

		System.out.println(sql);

		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			int id = rs.getInt("ID");
			String brandName = rs.getString("brandName");
			String trainerName = rs.getString("trainerName");
			String colour = rs.getString("colour");
			float size = rs.getFloat("size");
			String condition = rs.getString("condition");
			String description = rs.getString("description");
			int price = rs.getInt("Price");

			System.out.println(id + " " + brandName + " " + trainerName + " " + colour + " " + size + " " + condition
					+ " " + description + " " + price + " ");

			trainer = new Trainer(id, brandName, trainerName, colour, size, condition, description, price);

		}
		connection.close();
		return trainer;
	}

	public void insertTrainer(Trainer trainer) throws SQLException {
		Connection connection = getConnection();

		Statement statement = connection.createStatement();

		String sql = "INSERT INTO trainers (id,brandName,trainerName,colour,size,condition,description,price)"
				+ "VALUES (" + trainer.getId() + ", '" + trainer.getBrandName() + "','" + trainer.getTrainerName()
				+ "', '" + trainer.getColour() + "'," + trainer.getSize() + ", '" + trainer.getCondition() + "','"
				+ trainer.getDescription() + "'," + trainer.getPrice() + ");";

		System.out.println(sql);

		statement.executeUpdate(sql);

		System.out.println("inserted successfully");

		connection.close();

	}

	public void updateTrainer(Trainer updateTrainer) throws SQLException {
		Connection connection = getConnection();

		Statement statement = connection.createStatement();

		String sql = "UPDATE trainers " + "SET id = " + updateTrainer.getId() + ", brandName = '"
				+ updateTrainer.getBrandName() + "', colour = '" + updateTrainer.getTrainerName() + "', size = "
				+ updateTrainer.getSize() + ", condition = '" + updateTrainer.getCondition() + "', description = '"
				+ updateTrainer.getDescription() + "', price = " + updateTrainer.getPrice() + "" + " WHERE id = "
				+ updateTrainer.getId() + ";";

		System.out.println(sql);

		statement.executeUpdate(sql);
		System.out.println("updated successfully");

		connection.close();

	}

	public void deleteTrainer(int id) throws SQLException {
		Connection connection = getConnection();

		Statement statement = connection.createStatement();

		String sql = "DELETE FROM trainers " + " WHERE id = '" + id + "'";

		System.out.println(sql);

		statement.executeUpdate(sql);
		System.out.println("deleted successfully");

		connection.close();

	}

}
