import React, { useEffect, useState } from 'react'
import PeopleCard from './PeopleCard';
import PeopleService from '../../Services/PeopleService';
import People from '../../Models/People';

function PeopleList(props : any) {

    const {peopleList} = props;
    
    
  return (
  
    <div className='grid lg:grid-cols-3  bg-zinc-950 bg-white border border-neutral-50 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700 m-4 '>
       {peopleList.map((people : any )=> (
        <div key={people.id}>
            <PeopleCard people={people} />
        </div>
       ))} 
    </div>
  )
}

export default PeopleList
