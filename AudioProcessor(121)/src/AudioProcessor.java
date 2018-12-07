import java.util.*;

public class AudioProcessor {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter wav file name: ");
		String file = in.next();
		double[] sample = StdAudio.read(file);
		
		String command = "";
		
		while (!command.equals("q")){
			System.out.print("Select command (p, r, s, n, v, o, q): ");
			command = in.next();
			
			if (command.equals("p")){
				System.out.println("\tPlaying sound");
				StdAudio.play(sample);	
			}
			else if (command.equals("o")){
				System.out.print("\tSave to what file name? ");
				String newName = in.next();
				System.out.println("\tSaving file");
				StdAudio.save(newName, sample);	
			}
			
			else if (command.equals("r")){
				System.out.println("\tReversing sound");
				int beginning = 0;
				int end = sample.length - 1;
				while (beginning < end){
					double temp = sample[beginning]; //temp allows the array's beginning and end to swap
					sample[beginning] = sample[end];
					sample[end] = temp;
					beginning++;
					end--;
				}
				StdAudio.play(sample);
			}
			
			else if (command.equals("s")){
				System.out.print("\tSpeed up by how much? ");
				double speedUp = in.nextDouble();
				System.out.println("\tSpeeding up sound");
				double[] speed = new double [(int)(sample.length/speedUp)]; // speeds up or slows down original array and saves in a new one
				for (int i = 0; i < speed.length; i++){
					speed[i] = sample[(int)(speedUp*i)];
				}		
			StdAudio.play(speed);
			} 
			
			else if (command.equals("n")){
				System.out.print("\tAdd how much noise? ");
				double noiseAmount = in.nextDouble();
				System.out.println("\tAdding noise");
				for (int i = 0; i < sample.length; i++){
					double noise = Math.random() * noiseAmount - (noiseAmount * 2); // lets the range be between the positive and negative version of the users input
					sample[i] += noise;
						if(sample[i] > 1)
							sample [i] = 1; // if the noise created is greater than 1, it will be turned back into one
						else if (sample[i] < -1)
							sample[i] = -1; // if the noise is less than -1, it will be turned back into -1
				}
			StdAudio.play(sample);
			}
		
			else if (command.equals("v")){
				System.out.print("\tScale volume by how much? ");
				double volume = in.nextDouble();
				System.out.println("\tScaling volume");
				for (int i = 0; i < sample.length; i++){
					sample[i] *= volume;
					if (sample[i] > 1.0)
						sample[i] = 1.0; // if the volume created is greater than 1, it will be turned back into one
					else if (sample[i] < -1)
						sample[i] = -1; // if the volume is less than -1, it will be turned back into -1
				}
				StdAudio.play(sample);
			}
			
		}
	
	}

}
