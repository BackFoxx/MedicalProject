import { Grid, List, Paper } from '@mui/material';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import './App.css';
import FinalSelect from './SELECT/FinalSelect';
import R_Lists from './SELECT/List';
import { call } from './service/ApiService';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      Results: [],
    };
  }

  //ComponentDidMount
  componentDidMount() {
    call("/test", "GET", null)
      .then((response) => this.setState({ Results: response.data }));
    };

  //저장
  Save = function(SL) {
    call("/test", "POST", SL)
      .then((response) => this.setState({ Results: response.data }));
  }.bind(this)

  //삭제
  Delete = function(DL) {
    call("/test", "DELETE", DL)
      .then((response) => this.setState({ Results: response.data }));
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
