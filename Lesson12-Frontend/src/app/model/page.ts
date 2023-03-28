import {User} from "./user";

export class Pageable {

  constructor(public pageNumber: number,
              public pageSize: number,
              public offset: number,
              public paged: boolean,
              public unpaged: boolean) {
  }
}

export class Page {

  constructor(public content: User[],
              public pageable: Pageable,
              public last:boolean,
              public totalPages:number,
              public totalElements:number,
              public numberOfElements:number,
              public number:number,
              public first:boolean,
              public size:number,
              public empty:boolean) {
  }
}
