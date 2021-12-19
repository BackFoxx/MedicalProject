import React from "react";
import { ListItem, ListItemText, ListItemIcon, IconButton } from "@mui/material";
import HealingIcon from '@mui/icons-material/Healing';
import ClearIcon from '@mui/icons-material/Clear';

class R_Lists extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            Results: props.Results
        };
    }

    Delete = function() {
        this.props.onDelete(this.state.Results);
    }.bind(this)

    render() {
        return (

            <ListItem id={this.state.Results.day}>
                <ListItemIcon><HealingIcon /></ListItemIcon>
                <ListItemText>{this.state.Results.part}, {this.state.Results.symptom}, {this.state.Results.intensity}, {this.state.Results.day}</ListItemText>
                <IconButton onClick={this.Delete}><ClearIcon /></IconButton>
            </ListItem>

        );
    }
}

export default R_Lists;