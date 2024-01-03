package tododataList;

public class TodoDtls {
	private int id;
	private String name;
	private String todo;
	private String status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the todo
	 */
	public String getTodo() {
		return todo;
	}

	/**
	 * @param todo the todo to set
	 */
	public void setTodo(String todo) {
		this.todo = todo;
	}

	/**
	 * @return the ststus
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param ststus the ststus to set
	 */
	public void setStatus(String ststus) {
		this.status = ststus;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", todo=" + todo + ", ststus=" + status + "]";
	}

}
