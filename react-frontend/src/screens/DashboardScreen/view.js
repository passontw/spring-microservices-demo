import { useState } from "react";

// material-ui
import { Grid } from "@mui/material";
import { useTheme } from "@mui/material/styles";

// project imports
import { gridSpacing } from "constants";
import Button from "@mui/material/Button";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputAdornment from "@mui/material/InputAdornment";
import { IconSearch } from "@tabler/icons";
// ==============================|| DEFAULT DASHBOARD ||============================== //

const DashboardScreen = (props) => {
  const theme = useTheme();
  const [employeeId, setEmployeeId] = useState('');

  return (
    <Grid container spacing={gridSpacing}>
      <Grid item xs={12} spacing={8}>
        <Grid item xs={12}>
          <OutlinedInput
            sx={{ pr: 1, pl: 2, my: 2 }}
            id="input-search-profile"
            value={employeeId}
            onChange={(e) => setEmployeeId(e.target.value)}
            placeholder="Search profile options"
            startAdornment={
              <InputAdornment position="start">
                <IconSearch
                  stroke={1.5}
                  size="1rem"
                  color={theme.palette.grey[500]}
                />
              </InputAdornment>
            }
            aria-describedby="search-helper-text"
            inputProps={{
              "aria-label": "weight",
            }}
          />
          <Button onClick={() => {
            const payload = {employeeId};
            props.handleGetEmployeeById(payload)
          }}>送出</Button>
        </Grid>
        <Grid container spacing={gridSpacing}>
          <Grid item lg={4} md={6} sm={6} xs={12}>
            {JSON.stringify(props.employeeInfo)}
          </Grid>
        </Grid>
      </Grid>
    </Grid>
  );
};

export default DashboardScreen;
