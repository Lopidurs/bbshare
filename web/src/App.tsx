import { useQuery, gql } from '@apollo/client';
import React from 'react';
import './App.css';

interface User {
    id: string;
    firstname: string;
    lastname: string;
}

const GET_USERS = gql`
    query FindAllUsers {
        findAllUsers {
            id
            firstname
            lastname
        }
    }
`;

const App: React.FC = () => {
    return (
        <div>
            <h2>My first Apollo app 🚀</h2>
            <br/>
            <DisplayClients />
        </div>
    );
};

const DisplayClients: React.FC = () => {
    const { loading, error, data } = useQuery(GET_USERS);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error : {error.message}</p>;

    return data.findAllUsers.map(({ id, firstname, lastname }: User) => (
        <div key={id}>
            <h3>{firstname + " " + lastname}</h3>
        </div>
    ));
};

export default App;
