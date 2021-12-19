import React from "react";
import { ListItem, ListItemText, ListItemIcon } from "@mui/material";

class R_Lists extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            Results: props.Results
        };
    }

    render() {
        return (

            <ListItem>
                <ListItemText>{this.state.Results.part}, {this.state.Results.symptom}, {this.state.Results.intensity}, {this.state.Results.day}</ListItemText>
            </ListItem>

        );
    }
}

export default R_Lists;