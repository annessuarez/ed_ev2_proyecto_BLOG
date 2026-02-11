package ed_ev2_proyecto_BLOG;

import java.util.ArrayList;

public class Article {

	//Properties
	private int idArticle;
	private User user;
	private String title;
	private String content;
	private ArrayList<Comment> comments;
	
	//Constructors
	public Article(int idArticle, User author, String title, String content) {
		this.idArticle = idArticle;
		this.user = author;
		this.title = title;
		this.content = content;
		this.comments = new ArrayList<Comment>(); //inicializar el arrayList vacío
	}
	
	//Methods
	@Override
	public String toString() {
		return "Article [id=" + idArticle + ", author=" + user + "]" + "\n";
	}
	
	public String addComment(Comment comment) {
		if (comment != null) {
			comments.add(comment);
			return "Comment added successfully by: " + comment.getAuthor().getUsername();
		}else {
			return "Error: comment can't be added, is NULL.";
		}
	}
	
	public User getAuthor(){
		return user;
	}
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public ArrayList<Comment> getComments(){
		return comments;
	}
	
	public String showComments() { //mostrará una lista de usuarios : comentario
		String result = "";
		for (Comment comment : comments) {
			result += comment.getAuthor().getUsername() + " : " + comment.getText() + "\n";
		}
		return result;
	}
	
}
