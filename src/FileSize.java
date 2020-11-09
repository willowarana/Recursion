import java.awt.List;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FileSize {
	/*
	 * Directory
	 *|
	 *| file1 file2 file3 dir1
	 * 					   |
	 * 					   file 4 file5 dir2
	 * 									 |
	 * 									 |
	 * 									 file6
	 */
	
	public static long getSize(File file) {
		long size = 0;
		// if file => get size
		// if directory => get all of the files, and 
		// process all of the files and directories
		if(file.isDirectory()) {
			File[] files = file.listFiles();
					//for every of these files
			LinkedList<File> xFiles = 
					new LinkedList<>(Arrays.asList(files));
			for(File f: xFiles) {
				size += getSize(f);
			}
		}
			else {
				size += file.length();
			}
		
		return size;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please give me a directory or a file");
		String str = input.nextLine();
		System.out.println("The size is: " 
		+ getSize(new File(str)));
		
		

	}

}
