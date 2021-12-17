import React from "react";
import { Paper, Grid } from "@material-ui/core";


class Body extends React.Component {
    constructor(props) {
        super(props);
        this.state = { item: props.item };
    }
    
    render() {
        return (
            <div className="todo">
                <Grid item xs={3}>
                <Paper style={{ margin: 16, textAlign: "center" }} elevation={3}>
                <p id={this.state.item.id}>{this.state.item.id}</p>
                <p id={this.state.item.day}>{this.state.item.day}</p>
                <p id={this.state.item.part}>{this.state.item.part}</p>
                <p id={this.state.item.symptom}>{this.state.item.symptom}</p>
                <p id={this.state.item.intensity}>{this.state.item.intensity}</p>   
                </Paper>
                </Grid>
            </div>
        )
    }
}

export default Body;