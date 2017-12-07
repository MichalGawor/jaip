package lab6;

public enum Gender {
	MALE,FEMALE;

	public static Gender toEnum(String S){
		if(S.equalsIgnoreCase("male") || S.equalsIgnoreCase("m"))
		{
			return MALE;
		}
		if(S.equalsIgnoreCase("female") || S.equalsIgnoreCase("f")) 
		{
			return FEMALE;
		}
		return null; 
	}
	
	@Override
	public String toString (){
		String name="";
		if(MALE.equals(this)){
			name="Male";
			return name;
		} 
		if(FEMALE.equals(this)){
			name="Female";
			return name;
		}
		return null;
	}
	
	static boolean genderChecker(String S) throws MyExcepts{
		if(S.equalsIgnoreCase("male") || S.equalsIgnoreCase("m") || 
				S.equalsIgnoreCase("female") || S.equalsIgnoreCase("f"))
		{
			return true;
		}
		else
		{
			throw new GenderExcepts();
		}
	}
}

