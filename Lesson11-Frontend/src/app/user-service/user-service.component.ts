import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Page} from "../model/page";
import {User} from "../model/user";

@Component({
  selector: 'app-user-service',
  templateUrl: './user-service.component.html',
  styleUrls: ['./user-service.component.scss']
})
export class UserServiceComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  public findAll() {
    return this.http.get<Page>("api/v1/user")
  }

  public findById(id: number) {
    return this.http.get<User>(`api/v1/user/${id}/id`);
  }

  public save(user: User) {
    return this.http.put<User>('api/v1/user', user);
  }

  ngOnInit(): void {
  }

}
