import {TypeRapport} from "./enums/type-rapport";
import {TechnicienIT} from "./technicien-it";
import {AdministrateurIT} from "./administrateur-it";

export interface Rapport {
  id: number;
  type: TypeRapport;
  dateGeneration: Date;
  contenu: string;
  administrateurIT: AdministrateurIT;
  technicienIT: TechnicienIT;
}
