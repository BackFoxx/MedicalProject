import { Grid, List, Paper } from '@mui/material';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import './App.css';
import FinalSelect from './SELECT/FinalSelect';
import R_Lists from './SELECT/List';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      Results: [],
    };
  }

  //저장
  Save = function(SL) {
    const Item = this.state.Results;
    Item.push(SL);
    this.setState({ Results: Item });
  }.bind(this)

  //삭제
  Delete = function(DL) {
    const Item = this.state.Results;
    console.log(Item)
    const Filtered = Item.filter(e => e.day !== DL.day);
    this.setState({ Results: Filtered });
    console.log(Filtered)
  }.bind(this)

  render() {
    return (
      <div className='App'> 
        <FinalSelect Save={this.Save} />
        <List>
          {this.state.Results.map((Result, idx) => (
            <R_Lists onDelete={this.Delete} Results={Result} key={Result.day} />
          ))}
        </List>
      </div>
    );
  }
}

export default App;
