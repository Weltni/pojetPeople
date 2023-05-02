import People from "../Models/People";


export default class PeopleService{

    static peoples:People[];


    static getPeoples(): Promise<People[]> {
        return fetch('http://localhost:8080/people/', {
          method: "GET",
          headers: {}
          })
        .then(response => response.json())
        .catch(error => this.handleError(error));
    }

    static searchPeople(term : string): Promise<People[]> {
        return fetch(`http://localhost:8080/people/lastname?name=${term}`, {
          method: "GET",
          headers: {}
          })
        .then(response => response.json())
        .catch(error => this.handleError(error));
    }

    static getPeoplesid(id : number): Promise<People | null> {
        return fetch(`http://localhost:8080/people/find/${id}`, {
          method: "GET",
          headers: {}
          })
        .then(response => response.json())
        .then(data => this.isEmpty(data) ? null : data)
        .catch(error => this.handleError(error));
    }

    static deletePeople(people : People): Promise<People> {
      return fetch(`http://localhost:8080/people/${people.id}`, {
        method: "DELETE",
        headers: {}
        })
      .then(response => response.json())
      .then(data => this.isEmpty(data) ? null : data)
      .catch(error => this.handleError(error));
  }


  static isEmpty(data: object): boolean {
    return Object.keys(data).length === 0;
  }

  static handleError(error: Error): void {
    console.error(error);
  }
  


}