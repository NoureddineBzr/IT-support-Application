import {AdministrateurIT} from "./administrateur-it";

export interface Notification {
  id: number;
  message: string;
  dateEnvoi: Date;
  lu: boolean;
  administrateurIT: AdministrateurIT;
}
