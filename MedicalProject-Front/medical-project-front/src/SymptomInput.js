import React from "react";
import { Grid } from "@material-ui/core";
import DropdownItem from "react-bootstrap/esm/DropdownItem";
import { DropdownButton } from "react-bootstrap";

class SymptomInput extends React.Component {
    constructor(props) {
        super(props);
        this.state = { item: { part: this.props.part, symptom: "" } };
    }

    ViewState = (e) => {
        const Item = this.state.item;
        
        
        console.log(this.props.part);
        console.log(Item);
    }

    AddSymptom = (e) => {
        const Item = this.state.item;
        Item.symptom = e.target.innerHTML;
        this.setState = { item: Item };
        console.log(Item);
    }

    render() {
        return(
            
            <Grid container
            direction="row"
            justifyContent="center"
            alignItems="center">
                <DropdownButton id="dropdown-basic-button" title="Dropdown button">
                    <DropdownItem onClick={this.ViewState} href="#/action-1">State 보기</DropdownItem>
                    <DropdownItem onClick={this.add}>Another action</DropdownItem>
                    <DropdownItem>Something else</DropdownItem>
                </DropdownButton>
            </Grid>
        );
    }
}

export default SymptomInput