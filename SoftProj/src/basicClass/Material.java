package basicClass;

public class Material {
	private int materialID;
	private String title;
	private int ISBN;
	private String author;
	
	public Material(int ISBN,String author,String title)
	{
		this.materialID++;
		this.setTitle(title);
		this.setAuthor(author);
		this.setISBN(ISBN);
	}
	public int getMaterialID()
	{
		return this.materialID;
	}
	public String getTitle()
	{
		return this.title;
		
	}
	public String getAuthor()
	{
		return this.author;
	}
	public int getISBN()
	{
		return this.ISBN;
	}
	public void setISBN(int ISBN)
	{
		this.ISBN=ISBN;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	
	
	
	
	
}