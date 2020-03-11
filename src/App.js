import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';

class MyForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
       userName: '',
       cardNumber: '',
       cardLimit: '',
       cards: [],
    };
  }


//   async getDataAxios(){
//     const response =
//       await axios.get("http://localhost:10090/card/getall",      
//       )
//     console.log("axios  ",response.data)
//     return response.data;
// }

  componentDidMount() {
    fetch('http://localhost:10090/card/getall')
    .then(res => res.json())
    .then((data) => {
      this.setState({cards: data})
      console.log(this.state.cards)
    })
    .catch(console.log)
  }

  async addCardDetails()
  {
    const response = await fetch('http://localhost:10090/card/save', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({"userName":this.state.userName,
                          "cardNumber":this.state.cardNumber,
                          "cardLimit":this.state.cardLimit}),
    })
    console.log(await response.json())
  }

  mySubmitHandler = (event) => {
    //event.preventDefault();
    let cardnumber = this.state.cardNumber;
    let arr = (cardnumber + '')
      .split('')
      .reverse()
      .map(x => parseInt(x));
    let lastDigit = arr.splice(0, 1)[0];
    let sum = arr.reduce((acc, val, i) => (i % 2 !== 0 ? acc + val : acc + ((val * 2) % 9) || 9), 0);
    sum += lastDigit;
    if(!(sum % 10 === 0))
    {
      alert("Card number is not valid")
      return true;
    }
      this.addCardDetails();
     // this.componentDidMount();
  }
//4485275742308327
  
  myChangeHandler = (event) => {
    let nam = event.target.name;
    let val = event.target.value;
    let err = '';
    if (nam === "cardNumber") {
      if (val !== "" && !Number(val)) {
        err = <strong>Card Number must be a number</strong>;
      }
    }
    this.setState({errormessage: err});
    this.setState({[nam]: val});
  }

  render() {
    return (
      <form onSubmit={this.mySubmitHandler}>
      <h1>Credit Card System</h1>
      <h2>Add</h2>
      <p>Name:</p>
      <input
        type='text'
        name='userName'
        onChange={this.myChangeHandler}
      />
      <p>Card Number:</p>
      <input
        type='text'
        name='cardNumber'
        maxLength = '19'
        onChange={this.myChangeHandler}
      />
      {this.state.errormessage}
      <p>Limit:</p>
      <input
        type='text'
        name='cardLimit'
        onChange={this.myChangeHandler}
      />
      <br/>
      <br/>
      <input type='submit' value='Add'/>
      <h2 id='title'>Existing Cards</h2>
      <div className="container">
          <table className="table" id="cards">
            <thead>
              <tr>
                <th>Name</th>
                <th>Card Number</th>
                <th>Balance</th>
                <th>Limit</th>
            </tr>
        </thead>
        <tbody>
            {
                this.state.cards.map(
                    card =>
                        <tr key={card.cardNumber}>
                            <td>{card.userName}</td>
                            <td>{card.cardNumber}</td>
                            <td>£0</td>
                            <td>£{card.cardLimit}</td>
                        </tr>
                )
            }
        </tbody>
    </table>
  </div>
</form>
    );
  }
}

ReactDOM.render(<MyForm />, document.getElementById('root'));
