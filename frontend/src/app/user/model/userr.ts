import { Address } from "./address";
import { Bank } from "./bank";

export class Userr {
    id: string;
    fullName?: string;
    roles: string;
    userName?: string;
    password?: String;
    phoneNumber?: number;
    email: string;
    active:boolean;
    bank?: Bank;
    address?: Address;
    cropIds?:string[];
  }