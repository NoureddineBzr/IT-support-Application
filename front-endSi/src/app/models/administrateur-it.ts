import {Personne} from "./personne";
import {Rapport} from "./rapport";

export interface AdministrateurIT extends Personne {
  reports: Rapport[];
  notifications: Notification[];
}
