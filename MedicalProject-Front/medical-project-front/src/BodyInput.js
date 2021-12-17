import React from "react";
import { Button, Paper, Grid } from "@material-ui/core";
import SymptomInput from "./SymptomInput";

class BodyInput extends React.Component {
    constructor(props) {
        super(props);
        this.state = { item: { part: "" } };
        //선택한 부위를 저장할 오브젝트
    }

    AddPart = (e) => {
        const Item = this.state.item;
        Item.part = e.target.innerHTML;
        this.setState = { item: Item };
        console.log(Item);
        return <SymptomInput part="{this.state.item.part}" />
    }

    render() {
        return (
            <div>
            <Grid container
            direction="row"
            justifyContent="center"
            alignItems="center">
                <Paper>
                    <Button onClick={this.AddPart}>머리</Button>
                    <Button onClick={this.AddPart}>가슴</Button>
                    <Button onClick={this.AddPart}>다리</Button>
                </Paper>
            </Grid>
            </div>
        )
    }
}

export default BodyInput