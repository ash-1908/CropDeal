import { Address } from "./address";
import { Bank } from "./bank";

export interface User{
   
     userId ?: number;
	 userFullName ?:String;
	 userType ?:String;
	 userName ?:String;
	 password ?:String; 
	 mobileNo ?: number;
	 emailId ?:String;
	 userStatus ?:String;
     bank?:Bank;
     address?:Address;

}