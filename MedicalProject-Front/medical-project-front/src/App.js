import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from 'react';
import DaySelect from './SELECT/DaySelect';
import { Paper, Grid } from '@material-ui/core';
import './App.css';
import PartSelect from './SELECT/PartSelect';
import SymptomAndIntensity_Select from './SELECT/SymptomSelect';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { 
      Result: { day: "", part: "", symptom: "", intensity: "" }
    };
  }

  DaySelect = function(arg) {
    this.setState({
      Result: { day: arg }
    });
  }.bind(this)

  PartSelect = function(arg) {
    const state = this.state.Result;
    state.part = arg;
    this.setState({ Result: state });
  }.bind(this)

  render() {
    return (
      <div className='return'> 

        <DaySelect onaddDate={function(arg) { this.DaySelect(arg) }.bind(this)} />
        <PartSelect onaddPart={function(arg) { this.PartSelect(arg) }.bind(this)} />
        <SymptomAndIntensity_Select part={this.state.Result.part} />

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
