package com.delakdev.wvmanager.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private int attack;
	private int block;
	private int dig;
	private int passing;
	private int serve;
	private int age;
	private int trainingCount;
	private String image;
	@Enumerated(EnumType.STRING)
    private Position position;
	private boolean inTeam;
	private boolean inSubstitute;
	private boolean injured;
	private Ethnicity ethnicityId;
	private Team teamId;
	
	 public enum Position {
	 	LIBERO,
	 	MIDDLE_BLOCKER,
        OUTSIDE_HITTER,
        OPPOSITE,
        SETTER
    }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getDig() {
		return dig;
	}
	public void setDig(int dig) {
		this.dig = dig;
	}
	public int getPassing() {
		return passing;
	}
	public void setPassing(int passing) {
		this.passing = passing;
	}
	public int getServe() {
		return serve;
	}
	public void setServe(int serve) {
		this.serve = serve;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTrainingCount() {
		return trainingCount;
	}
	public void setTrainingCount(int trainingCount) {
		this.trainingCount = trainingCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isInTeam() {
		return inTeam;
	}
	public void setInTeam(boolean inTeam) {
		this.inTeam = inTeam;
	}
	public boolean isInSubstitute() {
		return inSubstitute;
	}
	public void setInSubstitute(boolean inSubstitute) {
		this.inSubstitute = inSubstitute;
	}
	public boolean isInjured() {
		return injured;
	}
	public void setInjured(boolean injured) {
		this.injured = injured;
	}
	public Ethnicity getEthnicityId() {
		return ethnicityId;
	}
	public void setEthnicityId(Ethnicity ethnicityId) {
		this.ethnicityId = ethnicityId;
	}
	public Team getTeamId() {
		return teamId;
	}
	public void setTeamId(Team teamId) {
		this.teamId = teamId;
	}
	
	public String getFullName() {
		
		return this.firstName+" "+this.lastName;
	}
	
	public String getShortName() {
		
		String firstLetter = this.firstName.substring(0, 1);
		return firstLetter+". "+this.lastName;
		
	}
	
	//attack value by position
	private int getAttackValue(Position position){
	        
        int attackvalue = this.attack;
        switch(position){
            case MIDDLE_BLOCKER:
            	attackvalue = (int) Math.round(attackvalue * 0.6);
                break;
            case OUTSIDE_HITTER:
            	attackvalue = (int) Math.round(attackvalue * 1.5);
                break;
            case OPPOSITE:
            	attackvalue = (int) Math.round(attackvalue * 2.2);
                break;
            case SETTER:
            	attackvalue = (int) Math.round(attackvalue * 0.3);
                break;
            case LIBERO:
            	attackvalue = (int) Math.round(attackvalue * 0.1);
                break;
        } 

        return attackvalue;
    }
	
	//block value by position
    private int getBlockValue(Position position){

        int blockValue = this.block;
        switch(position){
            case MIDDLE_BLOCKER:
                blockValue = (int) Math.round(blockValue * 2.5);
                break;
            case OUTSIDE_HITTER:
                blockValue =  blockValue * 1;
                break;
            case OPPOSITE:
                blockValue = (int) Math.round(blockValue * 0.8);
                break;
            case SETTER:
                blockValue = blockValue * 1;
                break;
            case LIBERO:
                blockValue = (int) Math.round(blockValue * 0.1);
                break;
        } 

        return blockValue;
    }
    
    //dig value by position
    private int getDigValue(Position position){

       int digValue = this.dig;
       switch(position){
           case MIDDLE_BLOCKER:
               digValue = (int) Math.round(digValue * 0.3);
               break;
           case OUTSIDE_HITTER:
               digValue = (int) Math.round(digValue * 0.8);
               break;
           case  OPPOSITE:
               digValue = (int) Math.round(digValue * 0.3);
               break;
           case SETTER:
               digValue = (int) Math.round(digValue * 0.7);
               break;
           case LIBERO:
               digValue = (int) Math.round(digValue * 2.5);
               break;
       } 

       return digValue;
    }
    
    //serve value by position
    private int getServeValue(Position position){

       int serveValue = this.serve;
       switch(position){
           case MIDDLE_BLOCKER:
               serveValue = (int) Math.round(serveValue * 1.2);
               break;
           case OUTSIDE_HITTER:
               serveValue = (int) Math.round(serveValue * 1.2);
               break;
           case OPPOSITE:
               serveValue = (int) Math.round(serveValue * 1.5);
               break;
           case SETTER:
               serveValue = (int) Math.round(serveValue * 1.5);
               break;
           case LIBERO:
               serveValue = (int) Math.round(serveValue * 0.1);
               break;
       } 

       return serveValue;
    }
    
    //passing value by position
    private int getPassingValue(Position position){

        int passingValue = this.passing;
        switch(position){
            case MIDDLE_BLOCKER:
                passingValue = (int) Math.round(passingValue * 0.4);
                break;
            case OUTSIDE_HITTER:
                passingValue = (int) Math.round(passingValue * 0.5);
                break;
            case OPPOSITE:
                passingValue = (int) Math.round(passingValue * 0.2);
                break;
            case SETTER:
                passingValue = (int) Math.round(passingValue * 2.5);
                break;
            case LIBERO:
                passingValue = (int) Math.round(passingValue * 2.2);
                break;
        } 

        return passingValue;
    }
    
    //get overall value of player
    public int getOverall() {
    	
    	Position position = this.position;
    	int overall = Math.round((this.getAttackValue(position) + this.getBlockValue(position) + this.getDigValue(position) + this.getPassingValue(position) + this.getServeValue(position)) / 5);
    	return overall;
	}
    
	 public void becomeOlder(){
	        
        int newAge = this.age++;
        this.setAge(newAge);

	 }

    public int getBuyingPrice(){
        int age = this.age;
        Position position = this.position;
        int finalPrice = 0;
        int priceByAge = 0;
        int priceByPosition = 0;

        //PriceByAge Bonus
        if(age < 41){
            priceByAge = 500;
        }
        else if(age < 36){
            priceByAge = 750;
        }
        else if(age < 31){
            priceByAge = 1000;
        }
        else if(age < 26){
            priceByAge = 1500;
        }
        else if(age > 15 && age < 21){
            priceByAge = 2000;
        }else{
            priceByAge = 0;
        }

        //PriceByPositionBonus
        switch(position){
            case OUTSIDE_HITTER:
                priceByPosition = 1500;
                break;
            case OPPOSITE:
                priceByPosition = 2000;
                break;
            case MIDDLE_BLOCKER:
                priceByPosition = 1000;
                break;
            case SETTER:
                priceByPosition = 1200;
                break;
            case LIBERO:
                priceByPosition = 750;
                break;
                
        }

        finalPrice = Math.round((priceByAge + priceByPosition) * this.getOverall());        
        return finalPrice;
    }


    public int getSellingPrice(){

        int sellPrice = Math.round(this.getBuyingPrice() / 2);
        return sellPrice;

    }
    
    

}
