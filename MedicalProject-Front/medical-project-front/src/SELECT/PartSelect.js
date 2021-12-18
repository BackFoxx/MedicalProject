import React from "react";
import { ButtonGroup, Button, Paper } from "@material-ui/core";

class PartSelect extends React.Component {
    
    addPart = function(e) {
        var part = e.target.textContent;
        this.props.onaddPart(part);
    }.bind(this)

    render() {
        return(
            <ButtonGroup color="secondary" variant="text" aria-label="text button group">
                <Button onClick={function(e) {this.addPart(e)}.bind(this)}>머리</Button>
                <Button onClick={function(e) {this.addPart(e)}.bind(this)}>배</Button>
                <Button onClick={function(e) {this.addPart(e)}.bind(this)}>다리</Button>
            </ButtonGroup>
        );
    }
}

export default PartSelect;