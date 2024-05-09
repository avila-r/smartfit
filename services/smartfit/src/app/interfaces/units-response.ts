import { Location } from "./location"

export interface UnitsResponse {
    currentCountryId: number,
    locations: Location[]
}