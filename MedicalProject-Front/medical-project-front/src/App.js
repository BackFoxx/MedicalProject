import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import './App.css';
import Body from './Controller';
import BodyInput from './BodyInput';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      items: [
        { id: 0, day: "20211216", part: "머리", symptom: "지끈거림", intensity: 8 },
        { id: 1, day: "20211217", part: "가슴", symptom: "답답함", intensity: 3 },
      ],
    };
  }

  render() {
    var Items = this.state.items.map((item,idx) => (
      <Body item={item} key={item.id} />
    ));
    return (
      <div className='return'> 
        <BodyInput />
        {Items}
      </div>
    );
  }
}

export default App;
