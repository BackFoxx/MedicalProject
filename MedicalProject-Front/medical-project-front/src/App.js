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

  ST_IN_Select = function(ST, IN) {
    const state = this.state.Result;
    state.symptom = ST;
    state.intensity = IN;
    this.setState({ Result: state });
  }.bind(this)

  render() {
    return (
      <div className='return'> 

        <DaySelect onaddDate={function(arg) { this.DaySelect(arg) }.bind(this)} />
        <PartSelect onaddPart={function(arg) { this.PartSelect(arg) }.bind(this)} />
        <SymptomAndIntensity_Select onaddSTIN={function(ST, IN) { this.ST_IN_Select(ST, IN) }.bind(this)} part={this.state.Result.part} />

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
