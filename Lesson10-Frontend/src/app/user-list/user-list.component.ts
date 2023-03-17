import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {UserServiceComponent} from "../user-service/user-service.component";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserServiceComponent) {
  }

  ngOnInit(): void {
    this.userService.findAll()
      .subscribe(response => {
        console.log(response.content)
        this.users = response.content;
      }, error => {
        console.log(error);
      })
  }

  delete(id: number | null) {

  }

}
