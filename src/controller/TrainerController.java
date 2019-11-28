package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import database.TrainerDAO;
import model.Trainer;

/**
 * this class will be used to test crud methods before implementing servlets.
 **/
public class TrainerController {

	public static void main(String[] args) {

		//Trainer insert = new Trainer(55, "Adidas", "Test", "blick", 9.5f, "new", "very nice", 1789);
		Trainer update = new Trainer(55, "update", "updateTest", "blick", 9.5f, "new", "very nice", 1789);
		TrainerDAO dao = new TrainerDAO();

		try {
			//dao.insertTrainer(insert);
			dao.updateTrainer(update);
			//dao.deleteTrainer(55);
			//dao.getSingleTrainer(2);

			ArrayList<Trainer> allTrainers = dao.getTrainers();

			// enhanced for loop creates object of Trainer class
			for (Trainer t : allTrainers) {
				System.out.println(t.getTrainerName());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
