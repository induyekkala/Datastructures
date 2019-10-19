import static org.junit.Assert.*;

import org.junit.Test;

public class TaskManagerTest {
	
	TaskManager tes=new TaskManager();
	UserTask u=new UserTask();

	@Test
	public void testSortProjectName() {
		
	}

	@Test
	public void testSortDueDate() {
		
	}

	@Test
	public void testFindTask() {
		
		
		u=tes.findTask("java");
		assertNotNull(u);
	}

	@Test
	public void testListOfTasks() {
		
		assertTrue(tes.listOfTasks().size()<=0);
	}

	@Test
	public void testRemoveTask() {
	
		for (int i=0;i<tes.listOfTasks().size();i++)
		{
			
			if(tes.listOfTasks().get(i).getTaskTitle().equals("java"))
			{
				
				tes.findTask("java");
			}  
		}
		
		u=tes.removeTask("java");
		assertNotNull(u);
		
		
	}

	@Test
	public void testEditTask() {
		
		
		tes.editTask("java");
		
	}

}
