import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-neweducaccion',
  templateUrl: './neweducaccion.component.html',
  styleUrls: ['./neweducaccion.component.css']
})
export class NeweducaccionComponent implements OnInit {
nombreE:string;
descripcionE:string;
  constructor(private educacionS: EducacionService, private router: Router) { }

  ngOnInit(): void {
  }
onCreate():void{
  const educacion = new Educacion(this.nombreE, this.descripcionE);
  this.educacionS.save(educacion).subscribe(
    data=>{
      alert("educacion añadida");
      this.router.navigate(['']);
    }, err =>{
      alert("fallo");
      this.router.navigate(['']);
    }
  )
}
}
