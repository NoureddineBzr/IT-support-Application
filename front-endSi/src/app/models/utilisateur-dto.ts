import {Role} from "./enums/role";

export interface UtilisateurDTO {
  id: number;
  username: string;
  email: string;
  password: string;
  role: Role;
}
