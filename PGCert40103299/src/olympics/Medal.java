package olympics;

/**
 * RONAN TIMONEY
 * 40103299
 *
 */

    public class Medal implements Comparable<Medal> {
	private int year;
	private String city; 
	private String sport;
	private String discipline;
	private String athlete;
	private String country;
	private String gender;
	private String event;
	private String medal;
	
	
	
	private final int yearMinValue = 1896;
	
	private final int countryLength = 3;

	private final int cityMinLength = 1;
	private final int cityMaxLength = 30;
	
	private final int sportMinLength = 1;
	private final int sportMaxLength = 50;
	
	private final int disciplineMinLength = 1;
	private final int disciplineMaxLength = 80;
	
	private final int athleteMinLength = 1;
	private final int athleteMaxLength = 80;
	
	private final int genderMinLength = 1;
	private final int genderMaxLength = 10;
	
	private final int eventMinLength = 1;
	private final int eventMaxLength = 50;
	
	
	
	
	public Medal(int year, String city, String sport, String discipline, String athlete, String country, String gender,
			String event, String medal) {
		super();
		this.year = year;
		this.city = city;
		this.sport = sport;
		this.discipline = discipline;
		this.athlete = athlete;
		this.country = country;
		this.gender = gender;
		this.event = event;
		this.medal = medal;
	}
	
	public Medal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Medal [year=" + year + ", city=" + city + ", sport=" + sport + ", discipline=" + discipline
				+ ", athlete=" + athlete + ", country=" + country + ", gender=" + gender + ", event=" + event
				+ ", medalType=" + medal + "]";
	}
	
	  
	public int getYear() {
		return year;
	}
	public int setYear(int year) {
		if(year>=yearMinValue) {
		this.year = year;
		} else {
			System.out.println("Invalid Year format");}
		return year;
	}
	
	
	public String getCountry() {
		return country;
	}
	

	public String setCountry(String country) {
		if(country.length()==countryLength) {
		this.country = country;} 
		else {System.out.println("Invalid Country format");} 
		return country;
		}
	
	
	public String getAthlete() {
		return athlete;
	}
	public String setAthlete(String athlete) {
		if(athlete.length()>=athleteMinLength && athlete.length()<=athleteMaxLength) {
			this.athlete = athlete;
		}
		else {
			System.out.println("Invalid Athlete format");
			}
		return athlete;
	}
	

	public String getCity() {
		
		return city;
	}
	public String setCity(String city) {
		if(city.length()>=cityMinLength && city.length()<=cityMaxLength) {
		this.city = city;
	}
	else {
		System.out.println("Invalid City format");
		}
		return city;
	}
	

	
	public String getSport() {
		return sport;
	}
	public String setSport(String sport) {
		if(sport.length()>=sportMinLength && sport.length()<=sportMaxLength) {
			this.sport = sport;
		}
		else {
			System.out.println("Invalid Sport format");
			}
		return sport;
	}
	
	

	
	public String getDiscipline() {
		return discipline;
	}
	public String setDiscipline(String discipline) {
		if(discipline.length()>=disciplineMinLength && discipline.length()<=disciplineMaxLength) {
			this.discipline = discipline;
		}
		else {
			System.out.println("Invalid Discipline format");
			}
		return discipline;
	}
	

	public String getGender() {
		return gender;
	}
	public String setGender(String gender) {
		if(gender.length()>=genderMinLength && gender.length()<=genderMaxLength) {
			this.gender = gender;
		}
		else {
			System.out.println("Invalid Gender format");
			}
		return gender;
	}
	
	

	
	public String getEvent() {
		return event;
	}
	public String setEvent(String event) {
		if(event.length()>=eventMinLength && event.length()<=eventMaxLength) {
			this.event = event;
		}
		else {
			System.out.println("Invalid Event format");
			}
		return event;
	}
	

	
	public String getMedal() {
		return medal;
	}
	public String setMedal(Integer medal) {
		if(medal==1){
		this.medal = "Gold";
	} else if (medal==2) {
	this.medal = "Silver";	
	} else if (medal==3) {
		this.medal = "Bronze";
	} else System.out.println("Invalid Medal format");
		return this.medal;
	}

	@Override
	public int compareTo(Medal o) {
		return 0;
	}

	
	@Override
    public boolean equals(Object o)
    {
        Medal c;
        if(!(o instanceof Medal))
        {
            return false;
        }
          
        else
        {
            c=(Medal)o;
            if(this.country.equals(c.getCountry()))
            {
                return true;
            }
        }
        return false;
    }



}