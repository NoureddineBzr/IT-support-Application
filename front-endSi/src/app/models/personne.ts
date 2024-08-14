import {Role} from "./enums/role";

export interface Personne {
  id: number;
  username: string;
  email: string;
  password: string;
  role: Role;
}
