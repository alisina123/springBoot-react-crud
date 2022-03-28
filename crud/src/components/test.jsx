return (
        
    <div className="container">
          <Toast ref={toast} />
        <div className="log-6">
            <Link to="/register">Register</Link>


            <table className="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">LastName</th>
                        <th scope="col">E-Mail</th>
                        <th scope="col">Parent</th>
                        <th scope="col">Detials</th>
                        <th scope="col">View</th>
                        <th scope='col'>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        students.map(
                            student =>
                                <tr key={student.id}>
                                    <th>{student.id}</th>
                                    <th>{student.name}</th>
                                    <th>{student.lastName}</th>
                                    <th>{student.email}</th>
                                    <th>{student.parent.name}</th>
                                    <th><Link to={`/studentDetails/${student.id}`}>Detials</Link></th>
                                    <th><Link to={`/UpdateStudent/${student.id}`}>View</Link></th>
                                    <th><button onClick={() => deleteStudent(student.id)} >Delete</button></th>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>

    </div>
      
)