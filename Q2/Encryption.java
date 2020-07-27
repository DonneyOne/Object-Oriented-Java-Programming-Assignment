import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.StreamCorruptedException;


public class Encryption{
	public static void main(String[] args) throws Exception{
		// The next couple lines were neccessery while testing the program. They save lines into a binary file named file.dat
		// String given = "fasdpioyhfasdpufhasupfhaspfhasdpfhasdpfhuasdfjasdfjkasdlfadks;fk;dsakD";
		// Secret gg = new Secret(given);
		// ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.dat"));
		// out.writeObject(gg);
		// out.close();
		if (args.length != 1)
		{
		System.err.println("One argument expected!");
		System.exit(1);
		}
		else{
		try{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0])); //Reading the binary file
		Secret read_binary = (Secret) in.readObject();
		System.out.println(read_binary); // Prints the text inside of the binary file
		String reads = read_binary.toString(); 
		in.close();
		for(int i=0; i<reads.length(); i++){ //Main loop that goes through every single of the characters inside of the string that is read.
			char single = reads.charAt(i);
			if(Character.isLowerCase(single)){ //An if statement checking if the character is lower case, otherwise it would not change it.
				if(single=='a'){ // If the character that is read is a - printing z
					System.out.print("z");

				}
				else{
					System.out.print((char)(single-1)); // for every single other character that is not "a" it would print the character's value -1, which would turn "b" into a and so on..
				}

			}
		else{
			System.out.print(single); // Prints the whole encrypted line. It cannot be println, because it would print for every character on new line.
		}
		}
	}
	catch(FileNotFoundException e){
		System.err.println("You havent given any file");}
	catch(ClassCastException e){
		System.err.println("The file cannot be decrypted");} // Error handling.
	catch(StreamCorruptedException e){
		System.err.println("The file should be binary");
	}
}
}
}