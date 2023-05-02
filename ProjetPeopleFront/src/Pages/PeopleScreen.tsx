import React, { useEffect, useState } from 'react'
import PeopleService from '../Services/PeopleService';
import PeopleList from '../Components/People/PeopleList';
import People from '../Models/People';
import Search from '../Components/Search';
import Header from '../Components/Header';

function PeopleScreen() {

    const [peopleList, setPeopleList] = useState<People[]>([]);
    useEffect(() => {
        PeopleService.getPeoples().then(peoples => setPeopleList(peoples));
    },[ ]);

  return (
    <div>
      <Header/>
      <h1 className="text-center text-6xl">List of People</h1>

<Search/>
      <div >
      <PeopleList peopleList={peopleList}/>
      </div>

      
    </div>
  )
}

export default PeopleScreen
