package olympics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * RONAN TIMONEY
 * 40103299
 *
 */
public class StarterApp {

	
	// stores the data read and mapped from the csv file
	public static ArrayList<Medal> medals = new ArrayList<Medal>();
	
	/**
	 * Reads data relating to Olympics medals and adds this data to an array of Medal objects 
	 * 
	 * @param outputList - the ArrayList to which the data will be added
	 * @param filename - the name of the file in which the data is stored
	 */
	public static void readMedalsFromFile(ArrayList<Medal> outputList, String filename) {
		try {
			File datasetSummer = new File("summer.csv");
			String line; 
			FileReader fReader = new FileReader(datasetSummer);
			BufferedReader bReader = new BufferedReader(fReader);

				line = bReader.readLine();
				line = bReader.readLine();

				while (line!= null) {
					

					String [] parts = line.split(",");
						
					int yearm1 = Integer.parseInt(parts[0]);
					String citym1 = parts[1];
					String sportm1 = parts[2];
					String disciplinem1 = parts[3];
					String countrym1 = parts[5];
					String athletem1 = parts[4];
					String genderm1 = parts[6];
					String eventm1 = parts[7];
					int medalm1 = Integer.parseInt(parts[8]);
					
			
					Medal m1 = new Medal();
					m1.setYear(yearm1);
					m1.setCity(citym1);
					m1.setCountry(countrym1);
					m1.setAthlete(athletem1);
					m1.setSport(sportm1);
					m1.setDiscipline(disciplinem1);
					m1.setGender(genderm1);
					m1.setEvent(eventm1);
					m1.setMedal(medalm1);
					
					outputList.add(m1);

					line = bReader.readLine();	
				}
			// end of file now reached  
		
			// close the open resources 
				bReader.close();
				fReader.close();
		
			// catch block
		}catch (FileNotFoundException e) {
			System.out.println("Error : File not found! ");
		}catch (IOException e) {
			System.out.println("Error : File could not be read !");
		}catch (Exception e) {
			
			System.out.println("Error : Unexpected error. Please try again later.");
		}

} // end of readMedalsFromFile method 
	
	
			// main method begins
		public static void main(String[] args) {

		// question 1
			
			readMedalsFromFile(medals, "summer.csv");
			removeIncompleteCountryData(medals);
			showMenu(medals);
			question14(medals);
			
			System.out.println("The End.");
			
		} // end of main method
		
		
		/**
		 * Removes any Medal objects from the specified ArrayList for which the 'Country' data was incomplete
		 * 
		 * @param inputList - an ArrayList of medals 
		 */
		public static void removeIncompleteCountryData(ArrayList<Medal> inputlist) {
			 for (int i=0; i<inputlist.size(); i++) {
					Medal current = inputlist.get(i);
					if (current.getCountry()==null) {
						inputlist.remove(i);
					}
					}
			 System.out.println("*** Incomplete data discounted ***");
			 System.out.println("");
			 System.out.println("");
		}
		
		
		// Question 2
		
			/**
			 * Outputs each Medal stored in the inputList to screen
			 * 
			 * @param inputList - an ArrayList of medals 
			 */
			public static void displayAllMedals(ArrayList<Medal> inputList){
			 for (int i=0; i<inputList.size(); i++) {
				Medal current = inputList.get(i);
				System.out.println(current);
			 }
			}
			

			
			// question 3
			
			/**
			 * Outputs each Medal of a specified type won by a specified country stored in the inputList to screen
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedCountry - Country (three letter format)
			 * @param soecifiedMedalType - Medal Type (Gold, Silver or Bronze)
			 */
			public static void spicifiedCountryAndMedalType(ArrayList<Medal> inputlist, String specifiedCountry, String specifiedMedalType){
				System.out.println("Medals "+specifiedMedalType+" won by "+specifiedCountry+" :");
				for (int i=0; i<inputlist.size(); i++) {
					Medal current = inputlist.get(i);
					String dataCountry = current.getCountry();
					String dataMedal = current.getMedal();
					if (specifiedCountry.equalsIgnoreCase(dataCountry)&&specifiedMedalType.equalsIgnoreCase(dataMedal)) {
						System.out.println(current.toString());
					}
				 }
				}
			
			// question 4
			
			/**
			 * Outputs a count of each Medal of a specified type won by a specified country stored in the inputList to screen
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedCountry - Country (three letter format)
			 */
			public static void setCountryAllMedalsPresented(ArrayList<Medal> inputlist, String specifiedCountry){
				String dataCountry;
				int goldCount = 0;
				int silverCount = 0;
				int bronzeCount = 0;
				
				for (int i=0; i<inputlist.size(); i++) {
					Medal current = inputlist.get(i);
					dataCountry = current.getCountry();
					String dataMedal = current.getMedal();
					if (specifiedCountry.equalsIgnoreCase(dataCountry)&&dataMedal.equalsIgnoreCase("Gold")) {
						goldCount++ ;
					} else if (specifiedCountry.equalsIgnoreCase(dataCountry)&&dataMedal.equalsIgnoreCase("Silver")) {
						silverCount++ ;
					} else if (specifiedCountry.equalsIgnoreCase(dataCountry)&&dataMedal.equalsIgnoreCase("Bronze")) {
						bronzeCount++ ;
					} 
			
				 }
				System.out.println("Medals won by "+specifiedCountry);
				System.out.println("Gold   : "+goldCount);
				System.out.println("Silver : "+silverCount);
				System.out.println("Bronze : "+bronzeCount);
				}
			
			
			// question 5 
			
			/**
			 * Outputs each Medal from a specified Year stored in the inputList to screen
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedYear - Year for which all Medals will be displayed
			 */
			public static void allMedalsSpecifiedYear(ArrayList<Medal> inpuList, int specifiedYear) {
				if(specifiedYear<1896) {
					System.out.println("Invalid year");
				}else {
				System.out.println("Medals in : "+specifiedYear);
				for(int i=0; i<inpuList.size(); i++) {
					Medal current = inpuList.get(i);
					int dataYear = current.getYear();
					if(specifiedYear==dataYear) {
						System.out.println(current.toString());
					}
				}}
			}
			
			
			// question 6
			
			/**
			 * Output to screen the total medals won by a specified athlete as per the inputList
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedAthlete - Athlete for which a medal count displayed
			 */
			public static void athleteMedalCount(ArrayList<Medal> inputList, String specifiedAthlete){
				String dataAthlete;
				int athleteMedalCount = 0;
				for (int i=0; i<inputList.size(); i++) {
					Medal current = inputList.get(i);
					dataAthlete = current.getAthlete();
					if (specifiedAthlete.equalsIgnoreCase(dataAthlete)) {
						athleteMedalCount++ ;
					} 
			
				 }
				System.out.println("Medals won by "+specifiedAthlete+" : "+athleteMedalCount);
				System.out.println();
				if(athleteMedalCount==0) {System.out.println("No medals found for "+specifiedAthlete+". Next time remember to search in the following format : Surname Firstname");
				System.out.println("e.g. for Usain Bolt, enter: Bolt Usain");
				System.out.println("");
				}
				}
			
			// question 7
			
			/**
			 * Output to screen the last year that medals were presented for a specified Sport
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedSport - Sport for which you would like to display the last year a medal medal was presented
			 */
			public static void lastYearSport(ArrayList<Medal> inputList, String specifiedSport){
				String dataSport;
				String medalCity;
				int medalYear = 0;
				medalCity = "Medal City";
				
				for (int i=0; i<inputList.size(); i++) {
					Medal current = inputList.get(i);
					dataSport = current.getSport();
					if (specifiedSport.equalsIgnoreCase(dataSport)) {
						medalYear = current.getYear();
						medalCity = current.getCity();
					} 
			
				 }
				System.out.println("Last year is "+medalYear+" in "+medalCity);
				if(medalYear==0) {
					System.out.println("No medals found for '"+specifiedSport+"'. Try another sport next time.");
				}
				System.out.println("");
				}
				
			
			// question 8
			
			/**
			 * Output to screen the total medals won by German (East and West and Unified Germany)
			 * 
			 * @param inputList - an ArrayList of medals
			 */
			public static void deleteBerlinWall(ArrayList<Medal> inputList){
				int germanCount = 0;
				String east = "GDR"; 
				String west = "FRG";
				String unified = "GER";
				for (int i=0; i<inputList.size(); i++) {
					Medal current = inputList.get(i);
					String dataCountry = current.getCountry();
					if (east.equalsIgnoreCase(dataCountry)||west.equalsIgnoreCase(dataCountry)||unified.equalsIgnoreCase(dataCountry)) {
						germanCount++ ;
					} 
			
				 }
				System.out.println("Total medals won by German (East and West and Unified Germany) : "+germanCount);
				}

				
			// question 9
			
			/**
			 * Output to screen Gold medals by specified Gender won by a particular country
			 * 
			 * @param inputList - an ArrayList of medals
			 * @param specifiedGender - the appropriate gender for which you would like to display the Gold medals won
			 * @param specifiedCountry - the Country for which you would like to display the Gold medals won (in a three-letter format)
			 */
			public static void goldsForGenderAndCountry(ArrayList<Medal> inputList, String specifiedGender, String specifiedCountry){
				int counter = 0;
				
				for (int i=0; i<inputList.size(); i++) {
					Medal current = inputList.get(i);
					String dataCountry = current.getCountry();
					String dataMedal = current.getMedal();
					String dataGender= current.getGender();
					if (specifiedCountry.equalsIgnoreCase(dataCountry)&&specifiedGender.equalsIgnoreCase(dataGender)&&dataMedal.equalsIgnoreCase("Gold")) {
					counter++;
					}
				 }
				System.out.println("Gold Medals won by "+specifiedGender+" from "+specifiedCountry+" : "+counter);
				}
			
			
			// question 10
			
			/**
			 * Output to screen the roll of honour of Olympic champions (male and female) for a particular Event
			 * 
			 * @param inpuList - an ArrayList of medals
			 * @param specifiedEvent - Event for which you would like the roll of honour 
			 */
			public static void honourRollEvent(ArrayList<Medal> inpuList, String specifiedEvent) {
				System.out.println("Gold medal winners in : "+specifiedEvent);
				String gender = "X";
				int count = 0;
				for(int i=0; i<inpuList.size(); i++) {
					Medal current = inpuList.get(i);
					String dataEvent = current.getEvent();
					if(current.getGender().equals("Women")) {
						gender = "(W)";
					} else if(current.getGender().equals("Men")) {
						gender = "(M)";
					}
					
					if(specifiedEvent.equalsIgnoreCase(dataEvent)&&current.getMedal().equalsIgnoreCase("Gold")) {
						System.out.println(current.getYear()+" "+current.getAthlete()+gender);
						count++;
					}
				}
				if (count==0) {
					System.out.println("No Gold medals found.");
					System.out.println("Did you search correctly?");
				
				}
				System.out.println();
				}
			
			// question 11
			
			/**
			 * Output to screen each country (sorted alphabetically) with the total gold medals each has won.
			 * 
			 * @param inputList - an ArrayList of Medals
			 */
			public static void totalGoldsEveryCountry(ArrayList<Medal> inputList) {
				
				System.out.println("Roll of honour - Gold Medals"); 
				System.out.println("LOADING...");
				 List<String> john1 = new ArrayList<String>();
				 
				 String q11;
				 
				 for (int i=0; i<inputList.size(); i++) {
						Medal current = inputList.get(i);
						String firstInstance = current.getCountry();
						q11 = (firstInstance+" "+(Collections.frequency(inputList, new Medal(2024, "City1", "AAA", "Sport1", "Ronan Timoney", firstInstance, "Male", "Olympics","Gold"))));	
			if(q11!=null) {
					john1.add(q11);}
				 }
			
				 Set<String> john9000 = new HashSet<String>(john1);
				 john1.clear();
				 john1.addAll(john9000);
				 Collections.sort(john1);
				 for(String o : john1) {
					 System.out.println(o);
				 }	
			}
			
			// question 12
			
			/**
			 * Output to screen each medal won by a particular county in a particular year in a particular sport.
			 * 
			 * @param inputlist - an ArrayList of Medals
			 * @param specifiedSport - the specified Sport for which you would like to output details
			 * @param specifiedCountry - the specified Country for which you would like to output details
			 * @param specifiedYear - the specified Year for which you would like to output details
			 */
			public static void medalDetailsSpecifiedSportCountryAndYear(ArrayList<Medal> inputList, String specifiedSport, String specifiedCountry, int specifiedYear) {
				 Collections.sort(inputList, new ComparaMedalsByAthleteName().reversed());
				for (int i=0; i<inputList.size(); i++) {
					Medal current = inputList.get(i);
					String dataCountry = current.getCountry();
					String dataSport = current.getSport();
					int dataYear= current.getYear();
					if (specifiedCountry.equalsIgnoreCase(dataCountry)&&specifiedSport.equalsIgnoreCase(dataSport)&&specifiedYear==dataYear) {
					System.out.println(current);
					}
				 }
				}
			
			// question 13
			
			/**
			 * Output to screen all host cities in alphabetical order. 
			 * 
			 * @param inputList - an ArrayList of Medals
			 */
			public static void hostCities(ArrayList<Medal> inputList) {
				 Collections.sort(inputList, new CompareMedalsByHostCity());
				 ArrayList<String> newList = new ArrayList<>();
				 String hostCity;
				for (Medal element : inputList) {
					hostCity= element.getCity();
					if (!newList.contains(hostCity)) {
						newList.add(hostCity);
					}
				} 
			 System.out.println(newList);
			}
			
			// question 14
			
			/**
			 * Export/write Medals to a new file (summer_updated.csv) with host City capitalised
			 * 
			 * @param inputList - an ArrayList of Medals
			 */
			public static void question14(ArrayList<Medal> inputList) {
				File file = new File ("summer_updated.csv");
				try {
				if (!file.exists()) {
						file.createNewFile();
				}
				
				FileWriter fw = new FileWriter(file, false);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Year");
				bw.write(",");
				bw.write("City");
				bw.write(",");
				bw.write("Sport");
				bw.write(",");
				bw.write("Athlete");
				bw.write(",");
				bw.write("Country");
				bw.write(",");
				bw.write("Medal");
				bw.newLine();
			
				for (Medal e : inputList) {
					
			bw.write(String.valueOf(e.getYear()));
			bw.write(",");
			bw.write(e.getCity().toUpperCase());
			bw.write(",");
			bw.write(e.getSport());
			bw.write(",");
			bw.write(e.getAthlete());
			bw.write(",");
			bw.write(e.getCountry());
			bw.write(",");
			bw.write(e.getMedal());
			bw.newLine();
				}
			
				bw.close();
				fw.close();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			/**
			 * Displays a menu to screen which allows the user to interact with Olympic medals data
			 * 
			 * @param m2 - an ArrayList of Medal objects
			 */
			public static void showMenu(ArrayList<Medal> m2) {
				Scanner scanner = new Scanner(System.in);
				int option;
				System.out.println("Olympics stats ");
				do {
					try {
					System.out.println(" 1.  Display all medals");
					System.out.println(" 2.  Output to screen the details of all medals for a specified medal type won by a specified country");
					System.out.println(" 3.  Output to screen the total of all medal types won by a specified country");
					System.out.println(" 4.  Output to screen the results of all medals won in a particular Olympic year.");
					System.out.println(" 5.  Output to screen the total medals won by a specified athlete.");
					System.out.println(" 6.  Output to screen the last year that medals were presented for a particular sport.");
					System.out.println(" 7.  Output to screen the total medals won by German (East and West and Unified Germany.");
					System.out.println(" 8.  Output to screen Gold medals by Gender won by a particular country.");
					System.out.println(" 9.  Output to screen the roll of honour of Olympic champions for a particular event.");
					System.out.println("10.  Output to screen each country and the total gold medals won.");
					System.out.println("11.  Output to screen each medal won by a particular county in a particular year in a particular sport.");
					System.out.println("12.  Output to screen a list of cities which have hosted the Summer Olympic Games");
					System.out.println("14.  ** Quit **");
					System.out.println("Enter option ...");
					
					
					option = scanner.nextInt();
					scanner.nextLine();
					
					
					switch (option) {
						
					case 1:
					// displayMyArray(m2);
						displayAllMedals(m2);
						
						break;
					case 2:
						System.out.println("SELECTED - Output to screen the details of all medals for a specified medal type won by a specified country");
						try {
						System.out.println("Select the country e.g. for Russia search RUS");	
						String sq22 = scanner.next(); 
						
						
						// spicifiedCountryAndMedalType(m2, sq21, sq21);
						
						if(sq22.length()==3) {
							System.out.println("Select the medal type - Gold, Silver or Bronze");	
							String sq21 = scanner.next();	
							if(sq21.equalsIgnoreCase("Gold")||sq21.equalsIgnoreCase("Silver")||sq21.equalsIgnoreCase("Bronze")) {
								spicifiedCountryAndMedalType(m2, sq22, sq21);
							} else {System.out.println("Invalid format. Next time remember to type only : Gold, Silver or Bronze");}
						System.out.println();
						scanner.nextLine();
						} else {
							System.out.println("Invalid format. Next time remember : for China enter CHN");
							System.out.println("");
							scanner.nextLine();
						}
						} catch (Exception e) {System.out.println("try again");
						scanner.close();
						}
						
						break;
					case 3:
						System.out.println("Select a country for summary e.g. for Russia search RUS");
						try {
						String sq11 = scanner.next(); 
						if(sq11.length()==3) {
						setCountryAllMedalsPresented(m2, sq11);
						System.out.println();
						System.out.println("End of medals for "+sq11);
						System.out.println();
						} else {
							System.out.println("Invalid country format. Next time remember : for China enter CHN");
							System.out.println("");
							scanner.nextLine();
						}
						} catch (Exception e) {System.out.println("try again");
						scanner.close();
						}
						
					
						
						break;
					
					case 4:
						System.out.println("Select a year : ");
						try {
						int sq41 = scanner.nextInt();
						if(sq41>= 1896) {
							allMedalsSpecifiedYear(m2, sq41);
						} else {System.out.println("Invalid year. Next time select 1896 or later.");}
						} catch (Exception e) {
							System.out.println("Please enter year in numerical form only");
							scanner.nextLine();
						}
						
						break;
						
					case 5:
						System.out.println("Please type the athlete name in this format : Surname forename");
						System.out.println("Select an athlete : ");
					
						try {
						String sq61 = scanner.nextLine();
						if(sq61!=null) {
						athleteMedalCount(m2, sq61);
						}  
						} catch (Exception e) {
							System.out.println("Error. Please try again.");
							scanner.nextLine();
						}
						break;
						
					case 6:
						System.out.println("Select a sport : ");
						try {
							String sq61 = scanner.nextLine();
							if(sq61!=null) {
							lastYearSport(m2, sq61);
							System.out.println("");
							}  
							} catch (Exception e) {
								System.out.println("Error. Please try again.");
								scanner.nextLine();
							}
						
						
							break;
					case 7:
						deleteBerlinWall(m2);
						System.out.println("");
						
						break;
					
					case 8:
						
						System.out.println("SELECTED - Output to screen Gold medals by Gender won by a particular country.");
						try {
						System.out.println("Select the country e.g. for Russia search RUS");	
						String sq81 = scanner.next(); 
						
						
						// spicifiedCountryAndMedalType(m2, sq21, sq21);
						
						if(sq81.length()==3) {
							System.out.println("Select Gender of athlete - Men or Women");	
							String sq82 = scanner.next();	
							if(sq82.equalsIgnoreCase("Men")||sq82.equalsIgnoreCase("Women")) {
								goldsForGenderAndCountry(m2, sq82, sq81);
							} else {System.out.println("Invalid format. Next time remember to type only Men or Women");}
						System.out.println();
						scanner.nextLine();
						} else {
							System.out.println("Invalid format. Next time remember : for China enter CHN");
							System.out.println("");
							scanner.nextLine();
						}
						} catch (Exception e) {System.out.println("try again");
						scanner.close();
						}
					
						break;
						
					case 9:
						
						System.out.println("Select the event : ");
					
						try {
						String sq91 = scanner.nextLine();
						if(sq91!=null) {
						honourRollEvent(m2, sq91);
						}  
						} catch (Exception e) {
							System.out.println("Error. Please try again.");
							scanner.nextLine();
						}
						
						
						break;
						
					case 10:

						totalGoldsEveryCountry(m2);
					
					break;
					case 11:
						// output to screen each medal won by a particular county in a particular year in a particular sport.
						
						System.out.println("SELECTED - Output to screen the details of each medal won by a particular county in a particular year in a particular sport.");
						try {
						System.out.println("Select the country e.g. for Russia search RUS");	
						String sq121 = scanner.next(); 
						if(sq121.length()==3) {
							System.out.println("Select the Year");	
							int sq122 = scanner.nextInt();	
							if(sq122>1896) {
								System.out.println("Select the Sport");
								String sq123 = scanner.next();
								if(sq123!=null) {
								medalDetailsSpecifiedSportCountryAndYear(m2, sq123, sq121, sq122);
								}  else System.out.println("Invalid sport.Please try again");
								
								///
							} else {System.out.println("Invalid format. Next time remember to type only : Gold, Silver or Bronze");}
						System.out.println();
						scanner.nextLine();
						} else {
							System.out.println("Invalid format. Next time remember : for China enter CHN");
							System.out.println("");
							scanner.nextLine();
						}
						} catch (Exception e) {System.out.println("try again");
						scanner.close();
						}

			
						
						break;
					case 12:
						
						hostCities(m2);
						
						break;
					case 13:
						System.out.println("13 was never an option.");
						break;
					case 14:
						System.out.println("Quitting");
						break;		
					default:
						System.out.println("Try options again...");
					}
				}catch(Exception e) {System.out.println("Please select a number between 1 & 14");
				scanner.nextLine();
				option = 999;
				}
				} while (option != 14); // end of do-while
				scanner.close();
			
			} // close the method
			
			}// close the class