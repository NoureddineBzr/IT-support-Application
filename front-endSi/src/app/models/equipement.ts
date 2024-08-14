import { EtatEquipement } from './enums/etat-equipement';
import { Panne } from './panne';

export interface Equipement {
  id?: number;
  nom: string;
  description: string;
  etat: EtatEquipement;
  dateAcquisition: string;
  pannes?: Panne[];
}


