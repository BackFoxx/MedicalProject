import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import DaySelect from './SELECT/DaySelect';
import { Paper, Grid } from '@material-ui/core';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      Result: { day: "", part: "", symptom: "", intensity: "" }
    };
  }

  render() {
    return (
      <div className='return'> 

        <DaySelect onaddDate={function(date) {
          this.setState({
            Result: { day: date }
          });
          console.log("넘어온 매개변수: " + date);
          console.log("저장된 state: " + this.state.Result.day);
        }.bind(this)} />

        <Grid item xs={4}>
          <Paper elevation={3}>
            <p>날짜: {this.state.Result.day}</p>
            <p>부위: {this.state.Result.part}</p>
            <p>증상: {this.state.Result.symptom}</p>
            <p>강도: {this.state.Result.intensity}</p>
          </Paper>
        </Grid>
      </div>
    );
  }
}

export default App;
