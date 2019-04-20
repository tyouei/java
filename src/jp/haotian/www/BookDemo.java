/**
 * 
 */
package jp.haotian.www;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.StructMember;

/**
 * @author deepin
 *
 */
public class BookDemo {

	/**
	 * 添加学生信息
	 * 
	 * @param tmpStudent
	 * @return
	 */
	//ArrayList是引用类型，只要在形参中指定即可
	//public ArrayList<Student> addStudent(Scanner scan,ArrayList<Student> tmpArray) {
	public static void addStudent(Scanner scan,ArrayList<Student> tmpArray) {
		while(true) {
			//定义学生句柄
			Student tmpStudent =new Student();
			System.out.println("请输入学生ID:");
			int intId=Integer.parseInt(scan.nextLine());
			
			System.out.println("请输入学生姓名:");
			String strName=scan.nextLine();
			//添加学生ID
			tmpStudent.setId(intId);
			//添加学生姓名
			tmpStudent.setName(strName);
			//添加学生信息
			tmpArray.add(tmpStudent);
			System.out.println("添加信息成功！"+tmpStudent.getId()+":"+tmpStudent.getName());
			if(tmpArray.size()>2) {
				System.out.println("添加信息终止了");
				break;
			}
			
		}

	}
	
    /**
     * 修正学生信息
     * @param tmpStudent
     * @param tmpArray
     * @return
     */
	public static void editStudent(Scanner scan,ArrayList<Student> tmpArray) {
		String flg="0";
		System.out.println("请输入要修正的学生ID：");
		int id = Integer.parseInt(scan.nextLine());
		
        //根据学生ID，查询修正对象。
		for(int i=0;i<tmpArray.size();i++) {
			//获取修正对象的学生信息
			Student student= tmpArray.get(i);
			if(student.getId()==id) {
				//修正学生的信息
				System.out.println("请输入新的姓名：");
				String strName=scan.nextLine();
				student.setName(strName);
				flg="1";
				System.out.println("学生的信息修正成功！");
				break;
			}
		}
		//不存在的情况，输出信息。
		if(flg.equals("0")) {
			System.out.println("你输入的学生ID不存在，请确认。");
		}
	}
	
    /**
     * 删除学生信息
     * @param tmpId
     * @param tmpArray
     * @return
     */
	public static void romoveStudent(Scanner scan,ArrayList<Student> tmpArray) {
		
		System.out.println("请输入要删除学生ID：");
		int tmpId= Integer.parseInt(scan.nextLine());
		//遍历集合，删除指定学生的信息
		for(int i=0;i<tmpArray.size();i++) {
			Student stu=tmpArray.get(i);
			if(stu.getId()==tmpId) {
				//删除指定的学生信息
				tmpArray.remove(i);
				System.out.println("学生ID="+tmpId+"的学生信息删除了。");
				break;
			}
		}
		
	}
	
	/**
	 * 查找指定学生的信息
	 * @param tmpId
	 * @param tmpArray
	 * @return
	 */
	public static void findInfo(Scanner scan,ArrayList<Student> tmpArray) {
		Student retS=new Student();
		int flg=0;
		System.out.println("请输入要查找的学生ID：");
		int tmpId=Integer.parseInt(scan.nextLine());
		//遍历集合，查找指定的学生的信息。
		for(int i=0;i<tmpArray.size();i++) {
			//获取集合中的学生对象
			retS=tmpArray.get(i);
			//判断是不是要查找的学生ID
			if(tmpId==retS.getId()) {
				//结果为真就终止循环
				System.out.println("学生ID：学生姓名："+retS.getId()+":"+retS.getName());
				flg=1;
				break;			
			}
		}
		//找不到的情况，输出信息；
		if(flg==0) {
			System.out.println("你输入的学生ID不存在，请确认。");
		}
		
	}
	/**
	 * 从键盘接受数据，并做相应的处理。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// this is test
		// System.out.println("Hello World!!");
		// 定义从键盘接受的句柄
		Scanner scnIn = new Scanner(System.in);
		// System.out.println(scnIn.nextInt());
		//定义学生集合
		ArrayList<Student> stuArraylist=new ArrayList<Student>();
		// 根据接受的数值，就行对应的业务处理
		while (true) {
			System.out.println("添加信息，请输入【1】");
			System.out.println("查询信息，请输入【2】");
			System.out.println("修正信息，请输入【3】");
			System.out.println("删除信息，请输入【4】");
			System.out.println("处理终止，请输入【5】");
			System.out.println("请输入选项：");
			switch (scnIn.nextLine()) {
			case "1":
				// 添加学生信息
				addStudent(scnIn,stuArraylist);
				break;
			case "2":
				
				findInfo(scnIn, stuArraylist);
				break;
				// 检索学生信息
			case "3":
				
				editStudent(scnIn, stuArraylist);
				break;
			// 修正学生信息
			case "4":
				// 删除学生信息
				
				romoveStudent(scnIn, stuArraylist);
				break;
			default:
				// 退出
				System.out.println("处理终止了！");
				System.exit(0);
			}

		}

	}

}
