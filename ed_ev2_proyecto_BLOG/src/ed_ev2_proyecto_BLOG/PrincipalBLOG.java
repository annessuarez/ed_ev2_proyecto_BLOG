package ed_ev2_proyecto_BLOG;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalBLOG {
	private static Scanner scaner = new Scanner(System.in);

	public static void main(String[] args) {
		String option = "";	
		Blog blog = new Blog();

		do {
			menu();
			option = scaner.nextLine();
			stateMachine(option, blog);

		}while(!option.equals("5"));	

	}

	private static void menu() {
		System.out.println(" ");
		System.out.println("----Welcome to Blog Manager----");
		System.out.println("Select an option:");
		System.out.println("1. Add a new article");
		System.out.println("2. Delete an article");
		System.out.println("3. Show an article by ID");
		System.out.println("4. Show all articles in the Blog");
		System.out.println("5. Exit");
		System.out.println("Option: ");
	}
	private static void stateMachine(String option, Blog blog) {

		switch (option) {
		case "1":
			System.out.println("1. Add a new article"); 
			System.out.print("Enter article ID (number): ");
			int id = Integer.parseInt(scaner.nextLine());
			System.out.print("Enter author username: ");
			String username = scaner.nextLine();
			System.out.print("Enter article title: ");
			String title = scaner.nextLine();
			System.out.print("Enter article content: ");
			String content = scaner.nextLine();

			User author = new User(username);
			Article article = new Article(id, author, title, content);
			String result = blog.addArticle(article);
			System.out.println("\n" + result);
			break;

		case "2":
			System.out.println("2. Delete an article");
			System.out.print("Enter article ID to delete: ");
			int idArticle = Integer.parseInt(scaner.nextLine());	        
			result = blog.removeArticle(idArticle);

			System.out.println("\n" + result);
			break;

		case "3":
			System.out.println("3. Show an article by ID");
			System.out.print("Enter article ID: ");
			idArticle = Integer.parseInt(scaner.nextLine());

			Article lookedArticle = blog.getArticle(idArticle);

			if (lookedArticle != null) {
				System.out.println("\n ARTICLE FOUND");
				System.out.println("ID: " + lookedArticle.getIdArticle());
				System.out.println("Author: " + lookedArticle.getAuthor().getUsername());
				System.out.println("Details: " + lookedArticle.toString());
				ArrayList<Comment> comments = lookedArticle.getComments();

				if (comments.isEmpty()) {
					System.out.println("No comments yet.");
				} else {
					System.out.println("\n COMMENTS (" + comments.size() + "):");
					System.out.println(lookedArticle.showComments());
				}
			} else {
				System.out.println("Article with ID " + idArticle + " not found.");
			}
			break;	
		case "4":
			System.out.println("4. Show all articles in the Blog");
		    String allArticlesText = blog.getAllArticles();
		    System.out.println(allArticlesText);
		    break;
		    
		default:
			break;
		}

	}

}
