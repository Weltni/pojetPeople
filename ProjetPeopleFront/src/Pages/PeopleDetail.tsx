import React, { useEffect, useState } from 'react'
import PeopleService from '../Services/PeopleService';
import People from '../Models/People';
import { useNavigate, useParams } from 'react-router-dom';



function PeopleDetail() {

  const navigate = useNavigate();
    const params = useParams();
console.log(params);

    const [people, setPeople] = useState<People | null >(null);
    useEffect(() => {
        PeopleService.getPeoplesid(Number(params.id)).then(people => setPeople(people));
    },[params]);

    const handleDelete = (people : People) => {
      PeopleService.deletePeople(people).then(() => navigate(`/`))
    }

  return (
    <div>
    {people ? (
  <>
  <h1>ID : {people.id}</h1>
    <h1>{people?.firstname} {people?.lastname} </h1>
    <h2>{people?.country}</h2>
    <p>EMAIL : {people?.email} / Téléphone : {people.phone}</p>

    <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
onClick={() => handleDelete(people)}>
  Delete
</button>


<button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
>
Add</button>
  </>
  
  ) :(
    <h1>PEOPLE INTROUVABLE</h1>
  )}




</div>
  )
}

export default PeopleDetail
