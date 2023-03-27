import { Component, OnInit } from '@angular/core';
import {User} from "../model/user";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  user = new User(null, "", "", "");
  error = false;
  errorMessage = "";


  constructor() { }

  ngOnInit(): void {
  }

}
