package ed.cuatrovientos.org;

public class Comment {
	//Properties
	private int idComment;
	private String text;
	private User author;
	
	//Constructors
		public Comment(int idComment, String text, User author ) {
			this.idComment = idComment;
			this.text = text;
			this.author = author;			
		}

	//Methods
		public User getAuthor() {
			return author;
		}
		
		public String getText() {
			return text;
		}

		public int getIdComment() {
			return idComment;
		}

		
}