package ed.cuatrovientos.org;

import java.util.ArrayList;

public class Article {

	//Properties
	private int idArticle;
	private String title;
	private String content;
	private User author;
	private ArrayList<Comment> comments;

	//Constructor
	public Article(int idArticle, String title, String content, User author) {
		this.idArticle = idArticle;
		this.title = title;
		this.content = content;
		this.author = author;   
		this.comments = new ArrayList<>();
	}

	//Methods
	public int getIdArticle() {
		return idArticle;
	}

	public User getAuthor() { 
		return author;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public String addComment(Comment comment) {
		if (comment == null) {
			return "Error: comment can't be added, is NULL.";
		}
		comments.add(comment);
		return "Comment added successfully by: " + comment.getAuthor().getUsername();
	}

	public String showComments() {
		if (comments.isEmpty()) {
			return "No comments yet.";
		}
		String result = "";
		for (Comment comment : comments) {
			result += comment.getAuthor().getUsername() + " : " + comment.getText() + "\n";
		}
		return result;
	}

	@Override
	public String toString() {
		return "Article ID: " + idArticle + 
				", Title: " + title + 
				", Author: " + author.getUsername();
	}
}
