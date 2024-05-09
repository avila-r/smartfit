export interface Location {
    id: number,
    title: string,
    content: string,
    opened: boolean,
    maskStatus: string,
    towelStatus: string,
    fountainStatus: string,
    lockerRoomStatus: string,
    schedules: Schedule[]
}

interface Schedule {
    weekdays: string,
    hour: string
}