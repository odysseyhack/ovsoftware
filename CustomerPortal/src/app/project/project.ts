export class Project {
    readonly name: string;
    readonly category: string;
    readonly description: string;
    readonly target: number;

    readonly image: string;
    readonly icon: string;
    readonly avatars: string[];

    progress: number;
}