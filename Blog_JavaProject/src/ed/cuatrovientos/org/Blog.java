package ed.cuatrovientos.org;
import java.util.ArrayList;
public class Blog {
	//Properties
	private ArrayList<Article> articles;

	//Constructor
	public Blog() {
		articles = new ArrayList<>();
	}

	//Methods
	public String addArticle(Article article) {
		if (article == null) {
			return "Error: the article is NULL.";
		}

		if (article.getAuthor() == null) {
			return "Error: the article must have an author.";
		}

		int newId = article.getIdArticle();
		for (Article existArt : articles) {
			if (existArt.getIdArticle() == newId) {
				return "Error: it already exists an article with " + article.getIdArticle() + " ID.";
			}
		}

		articles.add(article);
		return "Article added successfully: " + article.toString();
	}

	public String removeArticle(int idArticle) {
		for (int i = 0; i < articles.size(); i++) {
			Article art = articles.get(i);
			if(art.getIdArticle() == idArticle) {
				articles.remove(i);
				return "Article removed successfully: " + art.toString();
			}
		}
		return "Error: article not found with " + idArticle + " ID";
	}

	public Article getArticle(int idArticle) {
		for (Article article : articles) {
			if (article.getIdArticle() == idArticle) {
				return article;
			}
		}
		return null;
	}

	public String getAllArticles() {
		if (articles.isEmpty()) {
			return "No articles in the blog.";
		}

		String result = "=== ALL ARTICLES ===\n";
		int counter = 1;

		for (Article article : articles) {
			result += counter + ". " + article.toString() + "\n"; // ← salto de línea añadido
			counter++;
		}

		result += "====================\n";
		result += "Total: " + articles.size() + " articles";

		return result;
	}

	public void init() {
		articles.clear();
	}
}
